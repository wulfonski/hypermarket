import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProdCategoryDao;
import ro.sda.hypermarket.core.entity.ProdCategory;
import ro.sda.hypermarket.core.service.ProdCategoryService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProdCategoryDaoTest {
    @Autowired
    private ProdCategoryService prodCategoryService;

    @Test
    @Rollback(false)
    public void testCreateProdCategory() {
        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setName("Food");
        prodCategoryService.createProdCategory(prodCategory, false);
        Assert.assertEquals("Food", prodCategory.getName());

    }
    @Test
    @Rollback(false)
    public void testGetAllProdCategories() {

        ProdCategory prodCategory = new ProdCategory();
        prodCategory.setName("Cloths");
        prodCategoryService.createProdCategory(prodCategory, false);

        ProdCategory prodCategory1 = new ProdCategory();
        prodCategory1.setName("Food");
        prodCategoryService.createProdCategory(prodCategory1, false);

        List<ProdCategory> prodCategories = prodCategoryService.getAllProdCategories(false);
        Assert.assertEquals(7, prodCategories.size());
    }

    @Test
    public void testGetProdCategoryById() {
        ProdCategory prodCategory = prodCategoryService.getProdCategoryById(2L, false);
        Long prodCategoryId = prodCategory.getId();
        String prodCategoryName = prodCategory.getName();
        Assert.assertEquals("Electronics", prodCategoryName);
        Assert.assertEquals(new Long(2), prodCategoryId);
    }

    @Test
    @Rollback(false)
    public void testDeleteProdCategory(){
        List<ProdCategory> allCategories = prodCategoryService.getAllProdCategories(false);
        int size1 = allCategories.size();
        ProdCategory prodCategory = prodCategoryService.getProdCategoryById(2L, false);
        prodCategoryService.deleteProdCategory(prodCategory, false);
        List<ProdCategory> allCategories2 = prodCategoryService.getAllProdCategories(false);
        int size2 = allCategories2.size();
        Assert.assertEquals(size1 -1 , size2);
    }
    @Test
    @Rollback(false)
    public void testUpdateProdCategory(){

        ProdCategory prodCategory = prodCategoryService.getProdCategoryById(3L, false);
        prodCategory.setName("Electronics");
        String prodCategoryName = prodCategory.getName();
        prodCategoryService.updateProdCategory(prodCategory, false);
        Assert.assertEquals("Electronics", prodCategoryName);

    }
}
