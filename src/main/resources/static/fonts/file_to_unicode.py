## 
# args[1] = filter_file 
# args[2] = input_font
# args[3] = font_type
# args[4] = output_font
import sys
import os
uni_set = set()
with open(sys.argv[1], 'r') as f:
    for line in f.readlines():
        for char in line:
            tmp = str(hex(ord(char)))[2:]
            tmp = 'U+' + '0' * (4-len(tmp)) + tmp
            uni_set.add(tmp)

uni_list = list(uni_set)
sort_list = sorted(uni_list)
ckj = ','.join(sort_list)
uni = "U+0020-007F," + ckj
cmd_str = 'pyftsubset {in_file} --layout-features="" --unicodes="{uni}" --flavor={font_type} --output-file={out_file}'.format(
        in_file=sys.argv[2], font_type=sys.argv[3], out_file=sys.argv[4], uni=uni
        )
print(cmd_str)
os.system(cmd_str)
