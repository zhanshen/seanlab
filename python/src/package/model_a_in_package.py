'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
import package

variable_in_model = "The quick brown fox jumps over the lazy dog!"
variable_in_global = "I am the king of the world"

_variable_local = "I am local"


if __name__ == '__main__':
    print package.variable_package_access
    print variable_in_model
    print variable_in_global
    print _variable_local
    