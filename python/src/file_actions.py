'''
Created on Mar 25, 2011

@author: xiaoxiao
'''
import os

file_src = "./file_actions.py"
file_src_notexit = "/home/xiaoxiao/work/xxx"

def readfile_and_print(filepath):
    f = None
    try:
        f = open(filepath)
        print f.read()
    except IOError, e:
        print 'could not open file:', e
    finally:
        if (f is not None):
            f.close()
        
def readfile_traversal(filepath):
    f = None
    try:
        f = open(filepath)
        for line in f.xreadlines():
            print line
    except IOError, e:
        print 'could not open file:', e
    finally:
        if (f is not None):
            f.close()

def writefile(filepath, content):
    pass

def make_directory(dir_path):
    os.makedirs(dir_path)

if __name__ == '__main__':
    
    readfile_and_print(file_src)
    
    readfile_and_print(file_src_notexit)
    
    readfile_traversal(file_src)
    
