import sys
import os

#Solution to Kattis Problem FishMongers
#https://open.kattis.com/problems/fishmongers

#class to hold FishMonger price and amount
class FishMonger:
    def __init__(self, f, p):
        self.f=f
        self.p=p
#read your fish weights in
line = str.split(sys.stdin.readline())
a = [int(j) for j in line]
n = a[0]
m = a[1]
line = str.split(sys.stdin.readline())
fish = [int(j) for j in line]
#sort fish weights in reverse (descending) order
fish.sort(reverse=True)
fish_mongers = []
#read in fishMonger information
for i in range(m):
    line = str.split(sys.stdin.readline())
    fish_mongers.append(FishMonger(int(line[0]),int(line[1])))
#sort fishmongers based on price
sorted_fishmongers = sorted(fish_mongers, key=lambda FishMonger: FishMonger.p,reverse=True)
sum=0
index=0
#use greedy approach to value all your fish
for i in range(n):
    if index==m:
        break
    sum+=sorted_fishmongers[index].p*fish[i]
    sorted_fishmongers[index].f-=1
    if sorted_fishmongers[index].f==0:
        index+=1
print(sum)

        
