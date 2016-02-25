__author__ = 'Murugappan'
import sys
from itertools import permutations

permute=[]
def permutation(prefix,suffix):
    length=len(suffix)
    if len(suffix)==0:
        permute.append(prefix)
    else:
        for i in range(0,len(suffix)):
            permutation(prefix+suffix[i],suffix[:i]+suffix[i+1:length])


perms=["".join(p) for p in permutations(sys.argv[1])]

permutation("","rajesh")
print permute

sort=sorted(permute)

outputFile=open("anagram_out.txt","w")
for i in range(0,len(permute)):
    outputFile.write(sort[i])
    outputFile.write("\n")
