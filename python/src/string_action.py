'''
Created on Mar 24, 2011

@author: xiaoxiao
'''
import string

if __name__ == '__main__':
    
    string_sample = string.lowercase
    
    print string.digits
    
    print string.uppercase
    
    print string.lowercase
    
    """
    Also works in slice
    """
    print string_sample[1]
    
    print string_sample[1:3]
    
    print string_sample[:2]
    
    print string_sample[::2]
    
    print string_sample + string_sample
    
    print string_sample * 3

    template = string.Template('How many ${obj} are there?')
    
    print template.safe_substitute(obj="apples")
    
    print "海耶斯三双升空火箭"