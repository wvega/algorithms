#coding:utf-8

import fileinput
import os
import sys

def buy(credit, index, price, items):
    for item in items:
        if price + item[1] == credit:
            return (min(index, item[0]), max(index, item[0]))
    return None

def process(credit, items):
    m = credit / 2;
    greater = []
    smaller = []
    equals = []
    
    for i, item in enumerate(items.split(' ')):
        price = int(item)
        
        if price > m:
            greater.append((i+1, price))
            indexes = buy(credit, i+1, price, smaller)
        elif price < m:
            smaller.append((i+1, price))
            indexes = buy(credit, i+1, price, greater)
        else:
            indexes = buy(credit, i+1, price, equals)
            equals.append((i+1, price))
        
        if indexes is not None:
            break
    
    return indexes
    
def solve(input, output):
    for i in range(1,int(input.readline())+1):
        credit = int(input.readline())
        count = int(input.readline())
        indexes = process(credit, input.readline())
        output.write('Case #%d: %d %d\n' % (i, indexes[0], indexes[1]))
        
if __name__ == '__main__':
    if len(sys.argv) > 1:
        basename, extenstion = os.path.splitext(sys.argv[1])
        solve(open(sys.argv[1]), open('%s.out' % basename, 'w'))
