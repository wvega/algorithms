#coding:utf-8

import fileinput
import os
import sys

def process(n, sequence):
    state = [(1, 0), (1, 0), 0]
    for i in [2*k for k in range(0,n)]:
        bot = sequence[i] == 'B' and 1 or 0
        button = int(sequence[i+1])
        state[2] = state[2] + max(1, abs(button - state[bot][0]) + 1 - (state[2] - state[bot][1]))
        state[bot] = (button, state[2])
    return state[2]
    
def solve(input, output):
    for i in range(1,int(input.readline())+1):
        parts = input.readline().split(' ')
        seconds = process(int(parts[0]), parts[1:])
        output.write('Case #%d: %d\n' % (i, seconds))
        
if __name__ == '__main__':
    if len(sys.argv) > 1:
        basename, extenstion = os.path.splitext(sys.argv[1])
        solve(open(sys.argv[1]), open('%s.out' % basename, 'w'))
