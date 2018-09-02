import re
import string

letters = list(string.ascii_uppercase)


def my_lower(str_to_change):
    output = str_to_change
    # Changes only letters to lower, this avoids greek characters like omega and theta being messed up
    for char in letters:
        if char in output:
            output = output.replace(char, char.lower())
    return output


def cleanse(str_to_cleanse):
    remove_lst = ['#', ':', '*', '(', ')']
    for char in remove_lst:
        str_to_cleanse = str_to_cleanse.replace(char, "")
    return my_lower(str_to_cleanse).strip().replace(" ", "-")

# List of constant file paths
MD_FILE_NAME = "notes.md"
MD_BACKUP_PATH = "Source\MD Rendering"
MD_BACKUP_NAME = MD_FILE_NAME.replace(".md", ".bak")

# Open md file
with open(MD_FILE_NAME, encoding="utf-8") as file:
    # Read file contents into a string variable
    text = file.read()
    # Make sure we back up the original file
    with open("%s\%s" % (MD_BACKUP_PATH, MD_BACKUP_NAME), 'w', encoding="utf-8") as backup_file:
        backup_file.write(text)

# Header for TOC
TOC_HEADER = "# Table of Contents\n"

# Check if there is already a TOC header, if there is we need to remove it so our regex works
if TOC_HEADER in text:
    text = text.replace(TOC_HEADER, "")
    print("Removed existing TOC")

# Pretty shitty regex that identifies headers
regex_op = r"(^# +.*$)"
# Finds all headers in the file
match_obj = re.findall(regex_op, text, re.MULTILINE)

# If there is no header, then that's pretty weird
if match_obj is None or len(match_obj) == 0:
    print("You must have at least one # header.")
    exit(0)

# Identify the first header in the MD file, so we can put the TOC before it
first_header = match_obj[0]
print("Identified first header: %s" % first_header)
# Removes any exiting TOC that comes before the main header
text = text.replace(text.split(first_header)[0], "")
# A variable to store a separate table of contents for the README.md file, if needed
readme_toc = TOC_HEADER
# The main table of contents that will be generated
main_toc = TOC_HEADER
# Loops through each header to add a "return to index" option
for header in match_obj[:]:
    new_str = "%s\n[← Return to Index](#%s)\n" % (header, cleanse(TOC_HEADER))
    # Check if the link does not already 1exists
    if new_str not in text:
        text = text.replace(header, new_str)
        print("Added return link for header: %s" % header)
    else:
        print("There is already an index specifier for %s, great!" % header)

file_lines = text.split("\n")
# Store a list of headers in order
header_dict = {}
for line in file_lines:
    cleansed = cleanse(line)
    # Only track h1 -> h3
    if line.startswith("# ") or line.startswith("## ") or line.startswith("### "):
        header_dict[line] = cleansed

for key, val in header_dict.items():
    output_str = "* [%s](#%s)" % (key.replace("#", "").replace("*", "").strip(), val)
    readme_str = "* [%s](%s#%s)" % (key.replace("*", "").replace("#", "").strip(), MD_FILE_NAME, val)
    # Tracking how many tabs to indent result
    tab_count = key.count("#") - 1
    main_toc += "\t" * tab_count + output_str + "\n"
    readme_toc += "\t" * tab_count + readme_str + "\n"
# Append the TOC to the document contents
text = main_toc + text

# Write to file
write_conf = input("Write to notes.md file?")
if write_conf.lower().startswith("y"):
    with open(MD_FILE_NAME, 'w', encoding="utf-8") as output_file:
        output_file.write(text)

if input("Update README.md? ").strip().lower().startswith("y"):
    with open("readme.md", 'r+', encoding="utf-8") as readme_file:
        existing_text = readme_file.read()
        if "# Table of Contents" in existing_text:
            print("TOC Already Exists in README.md")
            existing_text = existing_text.split("# Table of Contents")[0].strip()
        updated_text = existing_text + "\n" + readme_toc
        readme_file.seek(0)
        readme_file.truncate()
        readme_file.write(updated_text)