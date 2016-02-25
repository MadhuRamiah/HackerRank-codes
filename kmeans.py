__author__ = 'Murugappan'
import sys
import math
import random

def distance(coordinates,centroid):
    value=[]
    for i in range(0,len(coordinates)):
        value.append(math.pow((float(coordinates[i])-float(centroid[i])),2))
    dist=math.sqrt(sum(value))
    return dist

def clustering(points,k,m):
    Cluster=[]
    for i in range(0,len(points)):
        dist=[]
        for j in range(0,k):
            dist.append(distance(m[j],points[i]))
        minimum=min(dist)
        print 'The distances are',dist
        print 'The minimum is',minimum
        index=dist.index(minimum)
        print 'Index is',index;
        Cluster.append(index);
    return Cluster


def calculate_centroid(indices):
    cent=[[]]
    for i in range(0,len(indices)):
        points_in_cluster=[[]]
        for j in range(0,len(indices[i])):
            points_in_cluster.append(points[indices[i][j]])
        del points_in_cluster[0]
        print 'Points are',points_in_cluster
        centroid_value=centroid(points_in_cluster,dimensions)
        print 'Value of centroid returned is ',centroid_value
        cent.append(centroid_value)
    del cent[0]
    print 'Centroid is',cent
    return cent

def centroid(points,dimensions):
    x_coords=[]
    for i in range(0,dimensions):
        x_coords.append([p[i] for p in points])
        print '%%%%%%%%%%%%%%%%%%%%%%%%',[p[i] for p in points]
    _len = len(points)
    print 'x coords are',x_coords
    centroid=[]
    for i in range(0,dimensions):
        x_coords[i]=map(float,x_coords[i])
        centroid.append(sum(x_coords[i])/_len)
    return centroid

"""Read input file"""
inputFile=open(sys.argv[5],'r')
line=inputFile.readline()
spl=line.strip().split(',')
outputFileName=sys.argv[5]+".output"
outputFile=open(outputFileName,'w')

"""Store dimensions from the file"""
dimensions=len(spl)
points=[[]]

"""Store the points"""
num_of_points=0;
print 'The number of dimensions is',dimensions

"""cluster size"""
number_of_clusters=int(sys.argv[1])
"""maximum trials allowed"""
max_trials=sys.argv[4]
"""threshold"""
threshold=float(sys.argv[3])

inputFile.seek(0)

while line not in ['\n','\r\n']:
    line=inputFile.readline()
    spl=line.strip().split(',')
    print line
    print len(spl)
    points_read=[]
    if len(spl)==dimensions:
        for i in range(0,dimensions):
            points_read.append(spl[i])
        points.append(points_read)
    else:
        break
del points[0]
print 'The points are',points

"""Cluster centers"""
m=[]
if(sys.argv[2]=='first'):
    for i in range(0,number_of_clusters):
        m.append(points[i])

if(sys.argv[2]=='rand'):
    print "Length is",len(points)-1
    print "Number of clusters",number_of_clusters
    rand=random.sample(range(0,len(points)),number_of_clusters)
    print "Random is",rand
    for i in range(0,number_of_clusters):
        m.append(points[rand[i]])
print 'The cluster centers are',m

Cluster_new=[]
Cluster=clustering(points,number_of_clusters,m)
print 'Clusters the points belong to',Cluster
count=1

while(1):
    """Storing index values for each cluster"""
    indices=[[]]
    for j in range(0,number_of_clusters):
        indices.append([i for i, x in enumerate(Cluster) if x == j])
    del indices[0]
    print indices

    m=calculate_centroid(indices)
    print 'All adjusted centroid points are',m

    Cluster_new=clustering(points,number_of_clusters,m)
    print 'The new Cluster points belong to',Cluster_new
    print 'The old cluster points are',Cluster

    """Second round of cluster"""
    indices=[[]]
    for j in range(0,number_of_clusters):
        indices.append([i for i, x in enumerate(Cluster_new) if x == j])
    del indices[0]
    print indices

    m1=calculate_centroid(indices)
    print 'All adjusted centroid points are',m1
    diff=0

    print 'value of m1 is',m1
    for i in range(0,len(m1)):
        diff+=distance(m[i],m1[i])

    print 'Difference is',diff
    """incrementing the number of times cluster is updated"""
    count+=1

    print "Count is",count
    print "Max trials is",max_trials
    """checking threshold value"""
    if diff<threshold:
        break

    """checking maximum trials"""
    if count>=max_trials:
        break

    Cluster=Cluster_new
for i in range(0,len(m1)):
    for j in range(0,dimensions):
        line1=outputFile.write(str(m1[i][j]))
        if j!=(dimensions-1):
            line1=outputFile.write(',')
    line1=outputFile.write("\n")

for i in range(0,len(Cluster_new)):
    line1=outputFile.write(str(Cluster_new[i]))
    line1=outputFile.write("\n")
print 'The final values of clusters are',Cluster_new