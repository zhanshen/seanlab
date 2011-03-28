'''
Created on Mar 28, 2011

@author: xiaoxiao
'''
import MySQLdb


if __name__ == "__main__":
    connection = MySQLdb.connect(host="bb-iit-dev01.bb01.baidu.com", user="root", db="testsample", passwd="iitmysql_dev01", port=8888)
    cur = connection.cursor()
    cur.execute("DELETE FROM person")
    cur.execute("INSERT INTO person VALUES ('1', 'xiaoxiao1')")
    cur.execute("INSERT INTO person VALUES ('2', 'xiaoxiao2')")
    cur.execute("INSERT INTO person VALUES ('3', 'xiaoxiao3')")
    cur.execute("INSERT INTO person VALUES ('4', 'xiaoxiao4')")
    cur.execute("SELECT * FROM person")
    for data in cur.fetchall():
        print '%s\t%s' % data
    connection.commit()
    connection.close()
    
