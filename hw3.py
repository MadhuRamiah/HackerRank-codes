__author__ = 'Murugappan'
import sys
import math
inputFile = open(sys.argv[2],'r')
outputFile = open("question1.txt",'w')
line=inputFile.readline()
spl = line.strip().split(' ')
diseases=int(spl[0])
people=int(spl[1])
print 'Number of diseases are',diseases
print 'Number of people are',people

disease=[]
symptoms=[]
symptomnames=[]
prioriprobablity=[]
present_probablity=[]
notpresent_probablity=[]

"""Computing true values"""
def probablity(resultset,priori1,present,notpresent):
    numerator=float(priori1)
    priori=float(priori1)
    denominator=float(1-priori)
    denominatorvalue=0
    for i in range(0,len(resultset)):
        if(resultset[i]=='T'):
            numerator=numerator*present[i]
        if(resultset[i]=='F'):
            numerator=numerator*(1-present[i])

    for i in range(0,len(resultset)):
        if(resultset[i]=='T'):
            denominator=denominator*notpresent[i]
        if(resultset[i]=='F'):
            denominator=denominator*(1-notpresent[i])

    final=numerator/(numerator+denominator)
    return ("{:.4f}".format(final))

"""Power function"""
def power(resultset):
    count=0
    mylist1=[]
    permlist=[]
    k=0
    for i in range(0,len(resultset)):
        if(resultset[i]=='U'):
            count=count+1
    powervalue=pow(2,count)
    power_calc=powervalue
    mylist=[]
    if(powervalue==1):
        return "unknown"
    if(powervalue==2):
        mylist.append('T')
        mylist.append('F')
        permlist.append(mylist)
        return permlist
    for i in range(0,count):
            mylist=[]
            mylist1=[]
            for j in range(0,powervalue/2):
                mylist.append('T')
            for j in range(powervalue/2,powervalue):
                mylist.append('F')
            if(len(mylist)==power_calc):
                mylist1=mylist
            if(len(mylist)!=power_calc):
                for k in range(0,pow(2,i)):
                    for m in range(0,len(mylist)):
                        mylist1.append(mylist[m])
            powervalue=powervalue/2
            permlist.append(mylist1)
    return permlist

"""Reading diseases names from file"""
for i in range(0,diseases):
    line=inputFile.readline()
    spl=line.strip().split(' ')
    print spl[0],spl[1],spl[2]
    disease.append(spl[0])
    symptoms.append(spl[1])
    prioriprobablity.append(spl[2])

    """Getting the symptoms as list for every disease"""
    line=inputFile.readline()
    mystring=str(line)
    mylist=eval(mystring)
    symptomnames.append(mylist)

    """Getting the probablity of having a symptom as list for every disease"""
    line=inputFile.readline()
    mystring=str(line)
    mylist=eval(mystring)
    present_probablity.append(mylist)

    """Getting the probablity of not having a symptom as list for every disease"""
    line=inputFile.readline()
    mystring=str(line)
    mylist=eval(mystring)
    notpresent_probablity.append(mylist)

print 'disease name is',disease
print 'symptoms are',symptoms
print 'priori probablity is',prioriprobablity
print symptomnames
probablity2=[]
probablity3=[]
probablity4=[]
"""Reading the values for all patients 1 by 1"""
for i in range(0,people):
    name="Patient-"+str(i+1)+":"
    line1=outputFile.write(str(name))
    line1=outputFile.write("\n")
    list2=[]
    list1=[]
    maxmin=[]
    d={}
    d1={}
    d2={}
    d3={}
    for j in range(0,diseases):
        maxlist=[]
        names=[]
        names1=[]
        maxmin=[]
        line=inputFile.readline()
        mystring=str(line)
        mylist=eval(mystring)
        finalprobablity=probablity(mylist,prioriprobablity[j],present_probablity[j],notpresent_probablity[j])
        diseaseprobablity=disease[j]+"\':\'"
        list1.append(str(diseaseprobablity)+str(finalprobablity))
        permlist=power(mylist)
        mylist_copy=[]
        for m in range(0,len(mylist)):
            mylist_copy.append(mylist[m])

        num=0
        if(permlist=="unknown"):
            unknown=0;
        else:
            for k in range(0,len(permlist[0])):
                for l in range(0,len(mylist)):
                    if(mylist[l]=='U'):
                        mylist_copy[l]=permlist[num][k]
                        num=num+1
                    else:
                        continue
                num=0
                probablity2.append(probablity(mylist_copy,prioriprobablity[j],present_probablity[j],notpresent_probablity[j]))

        del list2[:]
        if(len(probablity2)==0):
            list2.append(finalprobablity)
            list2.append(finalprobablity)
            maxmin.append(finalprobablity)
            maxmin.append(finalprobablity)
        else:
            list2.append(str(min(probablity2)))
            list2.append(str(max(probablity2)))
            maxmin.append(str(min(probablity2)))
            maxmin.append(str(max(probablity2)))
        d1[disease[j]]=maxmin
        del probablity2[:]

        mylist_copy1=[]
        for a in range(0,len(mylist)):
            mylist_copy1.append(mylist[a])

        indexes=[]
        for a in range(0,len(mylist)):
            if(mylist[a]=='U'):
                mylist_copy1[a]='T'
                probablity3.append(probablity(mylist_copy1,prioriprobablity[j],present_probablity[j],notpresent_probablity[j]))
                mylist_copy1[a]='F'
                probablity3.append(probablity(mylist_copy1,prioriprobablity[j],present_probablity[j],notpresent_probablity[j]))
                indexes.append(symptomnames[j][a])
                mylist_copy1[a]='U'

        if(len(probablity3)==0):
            maxlist.append('none')
            maxlist.append('N')
            maxlist.append('none')
            maxlist.append('N')
        else:
            indices = [i for i, x in enumerate(probablity3) if x == max(probablity3)]
            indices1 = [i for i, x in enumerate(probablity3) if x == min(probablity3)]
            for b in range (0,len(indices)):
                    names.append(symptomnames[j][indices[b]%2])
                    names.sort()

            for b in range (0,len(indices1)):
                    names1.append(symptomnames[j][indices[b]%2])
                    names1.sort()

            index1=int(indices[0])
            index2=int(indices1[0])
            if(index1%2==0):
                value='T'
            else:
                value='F'
            if(index2%2==0):
                value1='T'
            else:
                value1='F'

            index1=index1/2
            index2=index2/2
            maxlist.append(indexes[index1])
            maxlist.append(value)
            maxlist.append(indexes[index2])
            maxlist.append(value1)

        del probablity3[:]
        d[disease[j]]=str(finalprobablity)
        d2[disease[j]]=maxlist
    line1=outputFile.write(str(d))
    line1=outputFile.write("\n")
    line1=outputFile.write(str(d1))
    line1=outputFile.write("\n")
    line1=outputFile.write(str(d2))
    line1=outputFile.write("\n")