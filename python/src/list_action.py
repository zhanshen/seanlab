'''
Created on Mar 24, 2011

@author: xiaoxiao
'''

if __name__ == '__main__':
    sample_list = [1, 2, 3, 4, 5]
    
    print 3 in sample_list
    
    print 2 not in sample_list
    
    """
    Slice actions
    """
    print sample_list[1]
    
    print sample_list[1:3]
    
    print sample_list[:2]
    
    print sample_list[::2]
    
    print sample_list + sample_list
    
    print sample_list * 3
    
    print str(sample_list)
    
    #Convert to tuple
    print tuple(sample_list)
    
    #max
    print max(sample_list)
    
    #reverse
    for i in reversed(sample_list):
        print i
        
    #length
    
    print len(sample_list * 2)
    
    sample_list[3] = 123
    
    print (sample_list)
    
    sample_list.append(5)
    
    print sample_list
    
    sample_list.insert(2, 99)
    
    print sample_list
    
    sample_list.remove(5)
    
    print sample_list