
package com.example.websev.repository;

import com.example.websev.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class AddProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.REQUIRED)
    public int addNewProduct(Product product) {
        String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathroomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle) " +
//                "VALUES(:productId,:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathroomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle)";
              " VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathroomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle) ";

        Query query = entityManager.createNativeQuery(sql);
        //query.setParameter("productId", product.getProductId());
//        query.setParameter("productId", 20);

        query.setParameter("selectedPropertyType", product.getSelectedPropertyType());
        query.setParameter("selectedPriceRange", product.getSelectedPriceRange());
        query.setParameter("selectedRoomRange", product.getSelectedRoomRange());
        query.setParameter("selectedBathroomRange", product.getSelectedBathroomRange());
        query.setParameter("selectedLocationRange", product.getSelectedLocationRange());
        query.setParameter("selectedAreaRange", product.getSelectedAreaRange());
        query.setParameter("selectedFloorRange", product.getSelectedFloorRange());
        query.setParameter("isChecked", product.getIsChecked());
        query.setParameter("productName", product.getProductName());
        query.setParameter("productTitle", product.getProductTitle());

        return query.executeUpdate();
    }


}
