public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> remove = list.remove(0).getList();
            for (int i = remove.size() - 1; i >= 0; i--) {
                list.addFirst(remove.get(i));
            }
        }
        return !list.isEmpty();
    }
}
