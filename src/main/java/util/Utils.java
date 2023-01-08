package util;


import io.vavr.collection.LinearSeq;
public class Utils<E> {
    public void printCollectionInColumn(LinearSeq<E> collection) {
    for (E element : collection) {
            System.out.println(element);
        }
    }

}
