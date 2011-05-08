#coding:utf-8

import fileinput
import os
import sys

chars = ['Q', 'W', 'E', 'R', 'A', 'S', 'D', 'F']
base = [-1 for i in range(0,23)]
for i, k in enumerate([ord(c) - 65 for c in chars]):
    base[k] = i


def process(parts):
    scripts = [[[-1, 0] for i in range(0,8)] for i in range(0,8)]
    banned = [0 for i in range(0, 8)]
    elements = []
    k = 0
    
    C = int(parts[k])
    k = k + 1
    for i in range(0, C):
        combination = parts[k]
        k = k + 1
        
        A = base[ord(combination[0]) - 65]
        B = base[ord(combination[1]) - 65]
        R = ord(combination[2])
        
        scripts[A][B][0] = R
        scripts[B][A][0] = R
    
    D = int(parts[k])
    k = k + 1
    for i in range(0, D):
        opposed = parts[k]
        k = k + 1
        
        A = base[ord(opposed[0]) - 65]
        B = base[ord(opposed[1]) - 65]
        
        scripts[A][B][1] = 1
        scripts[B][A][1] = 1
        
    count = 0
    
    N = int(parts[k])
    k = k + 1
    invoke = parts[k]
    k = k + 1
    for i in range(0, N):
        B = base[ord(invoke[i]) - 65]
        elements.append(B)
        count = count + 1
        
        for j in range(0,8):
            if scripts[B][j][1] == 1:
                banned[j] = banned[j] + 1
        
        if count == 1:
            #print i, '-', B, elements, banned
            continue
        
        A = elements[-2]
        
        #print i, A, B, elements, banned
        
        if A < 8:
            combined = scripts[A][B][0]
            if combined > 0:
                elements[-2:] = [combined]
                count = count - 1
                
                for j in range(0,8):
                    if scripts[A][j][1] == 1:
                        banned[j] = max(0, banned[j] - 1)
                    if scripts[B][j][1] == 1:
                        banned[j] = max(0, banned[j] - 1)
                
                continue
        
        if banned[B] > 0:
            elements[:] = []
            banned = [0 for i in range(0, 8)]
            count = 0
            
    return elements
    
def solve(input, output):
    for i in range(1,int(input.readline())+1):
        #print 'Case #%d' % i
        elements = process(input.readline().split(' '))
        output.write('Case #%d: [%s]\n' % (i, ', '.join([i < 8 and chars[i] or chr(i) for i in elements])))
        
if __name__ == '__main__':
    if len(sys.argv) > 1:
        basename, extenstion = os.path.splitext(sys.argv[1])
        solve(open(sys.argv[1]), open('%s.out' % basename, 'w'))
