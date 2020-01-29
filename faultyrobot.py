import sys

class State:
    def __init__(self, location, buggyMoveLeft):
        self.location=location
        self.buggyMoveLeft=buggyMoveLeft
    def __hash__(self):
        g = str(self.location) + " " + str(self.buggyMoveLeft)
        return hash(g)
    def __eq__(self, other):
        if isinstance(other, State):
            return ((self.location == other.location) and (self.buggyMoveLeft == other.buggyMoveLeft))
        else:
            return False


class Node:
    def __init__(self, location, neighbors, forced):
        self.location=location
        self.neighbors=neighbors
        self.forced=forced


def visitState(newState):
    global marked
    if newState not in marked:
        marked.add(newState)
        dfs(newState)


def dfs(i):
    global marked
    global ending_locations
    global nodes
    if nodes[i.location] == 0:
        ending_locations.add(i.location)
        return
    cur = nodes[i.location]
    if cur.forced > 0:
        if i.buggyMoveLeft>0:
            for h in cur.neighbors:
                newState = State(h,0)
                visitState(newState)
        newState = State(cur.forced,i.buggyMoveLeft)
        visitState(newState)
    else:
        ending_locations.add(i.location)
        if i.buggyMoveLeft > 0:
            for h in cur.neighbors:
                newState = State(h,0)
                visitState(newState)


#read input
line = str.split(sys.stdin.readline())
n = int(line[0])
m = int(line[1])
nodes = [0] * (n + 1)

for i in range(m):
    line = str.split(sys.stdin.readline())
    a = int(line[0])
    b = int(line[1])
    f = True if a < 0 else False
    a = a * -1 if a < 0 else a
    if nodes[a]==0:
        nodes[a] = Node(a,set(),b) if f else Node(a,set([b]),-1)
    else:
        if f:
            nodes[a].forced=b
        else:
            nodes[a].neighbors.add(b)
#end of reading input
marked = set()
ending_locations = set()
start = State(1,1)
sys.setrecursionlimit(10000)
dfs(start)
print(len(ending_locations))
