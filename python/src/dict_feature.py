'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
sample_dict = {}

if __name__ == '__main__':
    
    #sample_dict["1"]  key error
    print sample_dict.get("1")
    
    another_dict = {'name': 'earth', 'port': 80, 'oo': "oo"}
    
    for key in another_dict:
        print 'key=%s, value=%s' % (key, another_dict[key])
        
    print another_dict.pop("oo")
    
    for key in another_dict:
        print 'key=%s, value=%s' % (key, another_dict[key])
        
    another_dict["oo"] = "aaa"
    del another_dict["oo"]
    
    sample_dict = another_dict.copy()
    
    print sample_dict.keys()
    
    print sample_dict.values()
    
    print sample_dict.items()