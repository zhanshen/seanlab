'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
import re

if __name__ == '__main__':
    mail_pattern = "(\w+)@\w+\.*\w+\.com"
    
    matcher = re.match(mail_pattern, "seanxiaoxiao@hotmail.com")
    
    if matcher is not None:
        print matcher.group()
        print matcher.group(1)
        print matcher.groups()