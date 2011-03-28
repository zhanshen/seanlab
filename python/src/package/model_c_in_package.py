'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
from package.model_a_in_package import *

def foo():
    print variable_in_model
    print variable_in_global
    print _variable_local

if __name__ == '__main__':
    foo()