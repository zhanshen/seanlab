'''
Created on Mar 25, 2011

@author: xiaoxiao
'''

b = 2

global_var = 3

def function_empty():
    pass

def function_simple_argument(a, b, c):
    print a
    print b
    print c


def function_tuple_argument(a, b, *c):
    print a
    print b
    print "length of c is: %d " % len(c)
    print c

def function_default_argument(a, b, c = 0):
    print a
    print b
    print c

def function_dict_argument(a, **b):
    print a
    for x in b:
        print x + ": " + str(b[x])
        
def function_multiple_return():
    return 1, 2, (3, 4), {1 : 3}


def function_closure(x):
    number = 2
    def incr():
        return number + x
    return incr()

def function_test_scope():
    print b
    b = 3
    
def function_test_global():
    global global_var
    global_var = 4
    print global_var

if __name__ == '__main__':
    function_simple_argument(1, 2, 3)
    function_tuple_argument(1, 2, 3, 4, 5)
    function_default_argument(1, 2, 3)
    function_dict_argument(1, m = 2, c = 3, abc = 4)
    print function_multiple_return()
    print function_closure(3)
    #print function_test_scope()
    print function_test_global()
    print global_var
