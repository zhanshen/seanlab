'''
Created on Mar 25, 2011

@author: xiaoxiao
'''
def full_featured_exception_handle(file_path):
    try:
        open(file_path)
    except (IOError, TypeError), reason:
        print reason
        raise
    except (Exception):
        pass
    else:
        print "Else clause"
    finally:
        print "Always here"


def handle_with(file_path):
    # feature supported after python 2.6
    with open(file_path) as f:
        for line in f:
            print line

def simply_rase():
    raise DerivedException()


class DerivedException(BaseException):
    pass



if __name__ == '__main__':
    #simply_rase()
    
    handle_with("./exception_feature.py")