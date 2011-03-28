'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
import unittest


class Target:
    
    def __init__(self):
        pass
    
    def method_with_return(self):
        return 1
    
    def method_with_arg(self, arg):
        return arg
    
    def method_with_exception(self, arg):
        if arg == 1:
            raise ValueError()

class Test(unittest.TestCase):


    def setUp(self):
        self.__target_obj = Target()

    def tearDown(self):
        pass

    def testMethodWithReturn(self):
        self.assertEqual(1, self.__target_obj.method_with_return(), "Test target obj for test method with return")

    def testMethodWithArg(self):
        self.assertEqual(2, self.__target_obj.method_with_arg(2), "Test target obj for test method with argument")

    def testMethodWithException(self):
        self.assertRaises(ValueError, self.__target_obj.method_with_exception, 1)

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()