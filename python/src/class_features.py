'''
Created on Mar 28, 2011

@author: xiaoxiao
'''

def annotation_method(cls):
    pass

class EmptyClass(object):
    pass

class ClassWithStaticMember(object):
    static_member = 1.2
    
class ClassWithPrivateStaticMember(object):
    __private_member = "in accessible"
    
class ClassWithMethod(object):
    
    def method(self):
        print "In method"
    
class ClassWithMember(object):
    
    def __init__(self, member):
        self.__member = member
    
    def getMember(self):
        return self.__member

class ClassWithNewAndInit(object):
    
    def __new__(cls):
        print "In new"
        return super(ClassWithNewAndInit, cls).__new__(cls)
    
    def __init__(self):
        print "In init"


class BaseClass(object):
    
    def __init__(self):
        self.__baseMember = "baseMember"
        self.__memberToOverride = "baseOverride"
    
    def getMemberToOverride(self):
        return self.__memberToOverride


class DerivedClass(BaseClass):
    
    def __init__(self):
        BaseClass.__init__(self)
        self.__memberToOverride = "derivedOverride"
    
    def getMemberToOverride(self):
        return self.__memberToOverride

    def getBaseMember(self):
        return BaseClass.__memberToOverride
    
if __name__ == '__main__':
    print ClassWithStaticMember.static_member
    static_member_obj1 = ClassWithStaticMember()
    ClassWithStaticMember.static_member = 1.5
    print static_member_obj1.static_member
    
    #print ClassWithPrivateStaticMember.__private_member
    
    class_with_method_obj = ClassWithMethod()
    class_with_method_obj.method()
    
    class_with_member_obj = ClassWithMember("Hello")
    print class_with_member_obj.getMember()
    
    class_with_new_and_init = ClassWithNewAndInit()

    class_base_obj = BaseClass()
    print class_base_obj.getMemberToOverride()
    
    class_derived_obj = DerivedClass()
    print class_derived_obj.getMemberToOverride()
    
    #Explicitly call for the method in base class
    print BaseClass.getMemberToOverride(class_base_obj)
    
    print isinstance(class_base_obj, BaseClass)
    
    print issubclass(DerivedClass, BaseClass)