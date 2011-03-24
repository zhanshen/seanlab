'''
Created on Mar 24, 2011

@author: xiaoxiao
'''

if __name__ == '__main__':
    
    tupleSample = ()
    
    listSample = [1, 2]
    
    dictSample = {1: "1", 2: "2"}
    
    numberSample = 3
    
    doubleSample = 3.2
    
    stringSample = "Hello World"
    
    original_tuple_id = id(tupleSample)
    
    original_list_id = id(listSample)
    
    listSample.append(3)
    
    print "After change: the id of list is same? %s" % (id(listSample) == original_list_id)
    
    original_dict_id = id(dictSample)
    
    dictSample[3] = "3"
    
    print "After change: the id of dict is same? %s" % (original_dict_id == id(dictSample))
    
    original_number_id = id(numberSample)
    
    numberSample += 1
    
    print "After change: the id of number is same? %s" % (original_number_id == id(numberSample))
    