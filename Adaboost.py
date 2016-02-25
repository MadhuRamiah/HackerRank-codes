from math import log
import math
import sys

__author__ = 'Murugappan'
lines=[[]]
attributes=[]
rows=[]
j=0
weights=[]
predicted=[]
misclassified=[]
selected=[]
H=[]
actual=[]
initial_weight=1.0/800
iterations=1
itervalue=int(sys.argv[1])
final_classH={}
array=[[1,1,2],[3,4,5]]
inputFile=open(sys.argv[2])

#reading the file mushroom.train
with open(sys.argv[2]) as f:
    content = f.read().splitlines()

#storing each value of 22 attributes in list
for i in range(0,len(content)):
    lines.append(content[i].split('\t'))
del lines[0]

#calculating total rows,columns
column=len(lines[0])
row=len(content)

#assigning initial weights to 1/row
for i in range(0,row):
    weights.append(initial_weight);

#storing all column values as a list
for j in range(0,column):
    attributes=[]
    for i in range(0,len(lines)):
        attributes.append(lines[i][j])
    rows.append(attributes)

#creating a dictionary of all the points
whole_list={}
for i in range(0,column):
    odour={}
    myset=set(rows[i])
    mylist=list(myset)
    for j in range(0,len(mylist)):
        if(i!=0):
            pos_neg={}
            pos_neg['pos']=0
            pos_neg['neg']=0
            pos_neg['entropy']=0
            odour.setdefault(mylist[j],pos_neg)
        else:
            odour.setdefault(mylist[j],0)
    whole_list.setdefault(i,odour)
#print whole_list

#calculate number of p and e in each different attribute
for j in range(0,column):
    for i in range(0,row):
        if(j!=0):
            if (rows[0][i]=='e'):
                whole_list[j][rows[j][i]]['pos']+=1
            else:
                whole_list[j][rows[j][i]]['neg']+=1
        else:
                whole_list[j][rows[j][i]]+=1

#initializing predicted and misclassified
for i in range(0,row):
    predicted.append(rows[0][i])
    misclassified.append(0)
    if(rows[0][i]=='p'):
        actual.append(-1)
    else:
        actual.append(1)

while(iterations<=itervalue):
    #print "-------------------------------------------------Iteration",iterations,"---------------------------------------------------------"
    #calculating IG
    final_classifier={}
    maxIG = 0;
    colWithMaxIG = 0;
    total=sum(weights)
    poisonous=0
    edible=0

    for k in range(0,row):
            if(rows[0][k]=='p'):
                poisonous+=weights[k]
            else:
                edible+=weights[k]

    poisonous=float(poisonous)/sum(weights)
    edible=float(edible)/sum(weights)
    #print poisonous,edible
    parent_entropy= -(poisonous)*log(poisonous,2)-(edible)*log(edible,2)
    #print 'Parent entropy is',parent_entropy

    #calculate Information gain
    for i in range(1,column):
        IG = 0;
        wtAvg = 0
        for j in range(0,len(whole_list[i])):
            poisonous=0
            edible=0
            child_weights=0
            str=whole_list[i].keys()[j]
            #print "String is",str
            for k in range(0,row):
                if rows[0][k]=='p' and rows[i][k]==str:
                    poisonous+=weights[k]
                    child_weights+=weights[k]
                if rows[0][k]=='e' and rows[i][k]==str:
                    edible+=weights[k]
                    child_weights+=weights[k]
            #print str," ",poisonous," ",edible," ",child_weights
            #if(poisonous==0):
            #    poisonous=0;
            #elif(edible==0):
            #    edible=0
            #else:
            #child_weights=edible+poisonous
            poisonous=float(poisonous)/child_weights
            edible=float(edible)/child_weights
            #print edible,poisonous
            #print child_weights
            if(poisonous==0 and edible==0):
                child_entropy=0
            elif(poisonous==0):
                child_entropy= -(edible)*log(edible,2)
            elif(edible==0):
                child_entropy= -(poisonous)*log(poisonous,2)
            else:
                child_entropy= -(poisonous)*(math.log(poisonous,2))-(edible)*(math.log(edible,2))
            whole_list[i][str]['entropy']=child_entropy
            wtAvg +=(child_entropy*child_weights/total)
        IG = parent_entropy - wtAvg;
        #print i,IG
        if IG > maxIG:
            maxIG = IG;
            colWithMaxIG = i;

    #the splitting attribute
    #print "Splitting attribute is",colWithMaxIG
    i=colWithMaxIG

    #assigning predicted and misclassified values
    number_of_misclassified=0
    sum1=0
    dict_values={}
    for j in range(0,len(whole_list[i])):
        str=whole_list[i].keys()[j]
        positive=0;
        negative=0;
        for k in range(0,row):
            if rows[i][k]==str:
                if rows[0][k]=='e':
                    positive+=weights[k]
                else:
                    negative+=weights[k]
        for k in range(0,row):
            if rows[i][k]==str:
                if positive>negative:
                        predicted[k]='e'
                        dict_values.setdefault(str,1)
                else:
                        predicted[k]='p'
                        dict_values.setdefault(str,-1)


    #print "actual is",rows[0]
    #print "predicted is",predicted

    for j in range(0,row):
        if predicted[j]!=rows[0][j]:
            misclassified[j]=1
        else:
            misclassified[j]=0

    number_of_misclassified=sum(misclassified)

    #calculating epsilon, alpha,etc
    epsilon=0

    for i in range(0,row):
        epsilon+=float(weights[i])*float(misclassified[i])
    #print "epsilon is",epsilon

    alpha=0
    alpha=float(0.5)*math.log(((1-epsilon)/epsilon),math.e)
    #print "alpha is",alpha

#calculate predicted
    H=[]
    for i in range(0,row):
        if(predicted[i]=='p'):
            H.append(-1)
        else:
            H.append(1)

#calculate z
    z=0
    for i in range(0,row):
        sign=-alpha*actual[i]*H[i]
        z+=weights[i]*(math.exp(sign))
    #print "z is",z

    for i in range(0,row):
        sign=-alpha*actual[i]*H[i]
        weights[i]=(weights[i]*(math.exp(sign)))/z
    accuarcy=(1.0-float(number_of_misclassified)/row)*100;
    #print "Unique weights are",set(weights)
    #print "Number of misclassified is",number_of_misclassified
    selected.append(colWithMaxIG)
    final_classifier.setdefault('selected',colWithMaxIG)
    final_classifier.setdefault('alpha',alpha)
    final_classifier.setdefault('feature',dict_values)
    final_classH.setdefault(iterations,final_classifier)
    #print final_classH
    iterations+=1


#testing data
with open(sys.argv[3]) as f:
    content = f.read().splitlines()

lines=[]
for i in range(0,len(content)):
    lines.append(content[i].split('\t'))

#calculating total rows,columns
column=len(lines[0])
row=len(content)

#print final_classH
predicted=[]
for i in range(0,row):
    value=0
    for j in range(0,len(selected)):
        if lines[i][selected[j]] in final_classH[j+1]["feature"].keys():
            value+=final_classH[j+1]["alpha"]*final_classH[j+1]["feature"][lines[i][selected[j]]]
        else:
            value+=final_classH[j+1]["alpha"]*1
    if(value<0):
        predicted.append('p')
    else:
        predicted.append('e')

#calculate the accuracy
actual=[]
count=0
for i in range(0,row):
    if lines[i][0]==predicted[i]:
        count+=1

print "Testing Accuracy is: ",100*float(count)/float(row),"%"
for i in range(1,itervalue+1):
    print "alpha",i,":", final_classH[i]["alpha"]

