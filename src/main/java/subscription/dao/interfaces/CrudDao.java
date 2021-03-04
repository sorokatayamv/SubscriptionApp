package subscription.dao.interfaces;

public interface CrudDao<T, K> {
    public T save(T obj); // CREATE

    public void remove(K id); // DELETE

    public void update(T obj, K id);// UPDATE

    public T get(Integer id); // READ
}
