import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProdCategoryDao;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.ProdCategory;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProdCategoryDaoTest {
    @Autowired
    private ProdCategoryDao prodCategoryDao;

    @Test
    public void testCreateProdCategory() {
        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setName("Food");
        prodCategoryDao.createProdCategory(prodCategory);

    }
    @Test
    public void testGetAllProdCategories() {

        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setName("Cloths");
        prodCategoryDao.createProdCategory(prodCategory);

        ProdCategory prodCategory1 = new ProdCategory();
        prodCategory.setName("Food");
        prodCategoryDao.createProdCategory(prodCategory);

        List<ProdCategory> prodCategories = prodCategoryDao.getAllProdCategories();
        Assert.assertEquals(2, prodCategories.size());
    }

    @Test
    public void testGetProdCategoryById() {
        ProdCategory prodCategory = prodCategoryDao.getProdCategoryById(1L);
        Long prodCategoryId = prodCategory.getId();
        String prodCategoryName = prodCategory.getName();
        Assert.assertEquals("Food", prodCategoryName);
        Assert.assertEquals(new Long(1), prodCategoryId);
    }

    @Test
    public void testDeleteProdCategory(){
        List<ProdCategory> allCategories = prodCategoryDao.getAllProdCategories();
        int size1 = allCategories.size();
        ProdCategory prodCategory = prodCategoryDao.getProdCategoryById(1L);
        prodCategoryDao.deleteProdCategory(prodCategory);
        List<ProdCategory> allCategories2 = prodCategoryDao.getAllProdCategories();
        int size2 = allCategories2.size();
        Assert.assertEquals(size1 -1 , size2);
    }
    @Test
    public void testUpdateProdCategory(){

        ProdCategory prodCategory = prodCategoryDao.getProdCategoryById(2L);
        prodCategory.setName("Electronics");
        String prodCategoryName = prodCategory.getName();
        prodCategoryDao.updateProdCategory(prodCategory);
        Assert.assertEquals("Electronics", prodCategoryName);

    }
}
