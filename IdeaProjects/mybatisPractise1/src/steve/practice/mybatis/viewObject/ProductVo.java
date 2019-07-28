package steve.practice.mybatis.viewObject;

import java.util.List;

public class ProductVo {
    private List<Integer> ids;

    public ProductVo(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
