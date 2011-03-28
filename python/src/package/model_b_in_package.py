'''
Created on Mar 28, 2011

@author: xiaoxiao
'''

import package.model_a_in_package as model_a

def foo():
    print model_a.variable_in_model
    print model_a.variable_in_global
    print model_a._variable_local

if __name__ == '__main__':
    foo()