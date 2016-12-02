package ua.training.patterns.iterator;

/**
 * <p> The Tasks class (some kind of collection).
 * This class implements Container interface, so we can take Iterator for Tasks class
 * utilizing method of Container interface.
 * This class represents Concrete Aggregate from Iterator pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class Tasks implements Container {
    String[] tasks = {"Build the house", "Give birth a son", "Plant a tree"};

    /**
     * This method returns concrete Iterator for Tasks class.
     *
     * @return new Task iterator
     */
    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    /**
     * This is inner class for Concrete iterator for Tasks class.
     */
    private class TaskIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
