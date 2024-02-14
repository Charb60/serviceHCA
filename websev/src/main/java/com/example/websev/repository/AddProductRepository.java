package com.example.websev.repository;
import com.example.websev.model.ImageProduct;
import com.example.websev.model.Product;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional
//    public List<Object[]> getProductWithImages(Long productId) {
//    public List<Object[]> getLatestProductId() {
//public List<Object[]> getLatestProductId() {
//
//
//    String jpql = "SELECT ip.imageId, p.productId, ip.image " +
//                "FROM ImageProduct ip " +
//                "INNER JOIN Product p ON ip.product = p.productId";
//
////        String jpql = " SELECT ip.imageId, p.productId, ip.image " +
////        " FROM " +
////        " imageproduct ip " +
////        " INNER JOIN " +
////        " product p ON ip.imageId = p.imageId ";
//
////        String jpql = " SELECT ip.imageId, p.productId, ip.image " +
////        " FROM " +
//////        " imageproduct ip " +
////                " ImageProduct ip " +
////                " INNER JOIN " +
//////                " product p ON ip.productId = p.productId ";
////        " Product p ON ip.productId = ip.productId ";
//
////        String jpql = "SELECT ip.imageId, p.productId, ip.image " +
////                "FROM ImageProduct ip " +
////                "INNER JOIN Product p ON ip.productId = p.productId";
//
//        Query query = entityManager.createQuery(jpql);
//
//        return query.getResultList();
//    }

//    public List<Object[]> getLatestProductId() {
//        String jpql = "SELECT ip.imageId, p.productId, ip.image " +
//                "FROM ImageProduct ip " +
//                "INNER JOIN Product p ON ip.product = p.product";
//        Query query = entityManager.createQuery(jpql);
//        return query.getResultList();
//    }

//    public Long getLatestProductId() {
//        String jpql = "SELECT MAX(p.productId) FROM Product p";
//        Query query = entityManager.createQuery(jpql);
//        return (Long) query.getSingleResult();
//    }


//@Transactional
//public Long getLatestProduct() {
//    String jpql = "SELECT MAX(p.productId) FROM Product p";
//    Query query = entityManager.createQuery(jpql);
//    return (Long) query.getSingleResult();
//}


    @Transactional(Transactional.TxType.REQUIRED)
    public int addNewProduct(Product product) {
        String sql = "INSERT INTO product (selected_property_type, selected_price_range, selected_room_range, selected_bath_room_range, selected_location_range, selected_area_range, selected_floor_range, is_Checked, product_name, product_title,latitude,longitude) " +
                "VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathRoomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :is_Checked, :productName, :productTitle,:latitude,:longitude)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("selectedPropertyType", product.getSelectedPropertyType());
        query.setParameter("selectedPriceRange", product.getSelectedPriceRange());
        query.setParameter("selectedRoomRange", product.getSelectedRoomRange());
        query.setParameter("selectedBathRoomRange", product.getSelectedBathRoomRange());
        query.setParameter("selectedLocationRange", product.getSelectedLocationRange());
        query.setParameter("selectedAreaRange", product.getSelectedAreaRange());
        query.setParameter("selectedFloorRange", product.getSelectedFloorRange());
        query.setParameter("is_Checked", product.getIsChecked());
        query.setParameter("productName", product.getProductName());
        query.setParameter("productTitle", product.getProductTitle());
        query.setParameter("latitude", product.getLatitude());
        query.setParameter("longitude", product.getLongitude());
//        query.setParameter("productId", product.getProductId());

        return query.executeUpdate();

    }
//    @Transactional(Transactional.TxType.REQUIRED)
//    public int addImages(ImageProduct imageproduct) {
//        String sql = "INSERT INTO imageproduct (image) VALUES (:image)";
//        Query query = entityManager.createNativeQuery(sql);
//        query.setParameter("image", imageproduct.getImage());
////        query.setParameter("productId", imageproduct.getProductId());
//        return query.executeUpdate();
//    }


@Transactional(Transactional.TxType.REQUIRED)
public int addImages(ImageProduct imageproduct) {
    // ดึง productId ล่าสุดจากตาราง product
//    List<Object[]> latestProductId = getLatestProductId();
//   Product latestProductId = (Product) getLatestProductId();

    // สร้างคำสั่ง SQL สำหรับเพิ่มข้อมูลกับรูป
    String sql = "INSERT INTO imageproduct (product_id, image) VALUES (:product, :image)";
//    String sql = "INSERT INTO imageproduct (image) VALUES (:image)";
    Query query = entityManager.createNativeQuery(sql);
    query.setParameter("product", imageproduct.getProduct());
    query.setParameter("image", imageproduct.getImage());


    return query.executeUpdate();
}


//        @Transactional(Transactional.TxType.REQUIRED)
//    public int addNewProduct(Product product) {
//
////        String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathRoomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle,imageId) " +
////                " VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathRoomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle,:imageId) ";
//
////        String sql = "INSERT INTO product (selectedPropertyType, selectedPriceRange, selectedRoomRange, selectedBathRoomRange, " +
////                "selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked, productName, productTitle, latitude, longitude) " +
//
//
//        String sql =" INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathRoomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle) " +
//       " VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathRoomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle) ";
//        String sql =" SELECT :product.selectedPropertyType,:product.selectedPriceRange,:product.selectedRoomRange, " +
//                " :product.selectedBathRoomRange, :product.selectedLocationRange, :product.selectedAreaRange, " +
//                " :product.selectedFloorRange, :product.isChecked, :product.productName, :product.productTitle, " +
//                " :imageproduct.imageId " +
//        " FROM product " +
//         " INNER JOIN imageproduct ON product.imageId = imageproduct.imageId ";
//
//
//
//
////        String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathroomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle) " +
////              "VALUES(:productId,:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathroomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle)";
//
//        //String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathroomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle,productImage) " +
////        String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathroomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle,productImage) " +
////        String sql = " INSERT INTO product (selectedPropertyType ,selectedPriceRange, selectedRoomRange, selectedBathroomRange, selectedLocationRange, selectedAreaRange, selectedFloorRange, isChecked,productName,productTitle) " +
////                " VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathroomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle) ";
//
////                " VALUES(:selectedPropertyType, :selectedPriceRange, :selectedRoomRange, :selectedBathroomRange, :selectedLocationRange, :selectedAreaRange, :selectedFloorRange, :isChecked,:productName,:productTitle,:productImage ) ";
//
//        Query query = entityManager.createNativeQuery(sql);
//        //query.setParameter("productId", product.getProductId());
////        query.setParameter("productId", 20);
//
//        query.setParameter("selectedPropertyType", product.getSelectedPropertyType());
//        query.setParameter("selectedPriceRange", product.getSelectedPriceRange());
//        query.setParameter("selectedRoomRange", product.getSelectedRoomRange());
//        query.setParameter("selectedBathRoomRange", product.getSelectedBathRoomRange());
//        query.setParameter("selectedLocationRange", product.getSelectedLocationRange());
//        query.setParameter("selectedAreaRange", product.getSelectedAreaRange());
//        query.setParameter("selectedFloorRange", product.getSelectedFloorRange());
//        query.setParameter("isChecked", product.getIsChecked());
//        query.setParameter("productName", product.getProductName());
//        query.setParameter("productTitle", product.getProductTitle());
//        //        query.setParameter("latitude", product.getLatitude());
////        query.setParameter("longitude", product.getLongitude());
////        query.setParameter("productImage", product.getProductImage());
//
////        query.setParameter("image", product.getImage());
//
//        return query.executeUpdate();
//    }
@Transactional(Transactional.TxType.SUPPORTS)
public ArrayList<Product> queryAllProduct() {
//    String sql = "SELECT p.product_id, p.selected_property_type, p.selected_price_range, " +
//            "p.selected_room_range, p.selected_bath_room_range, p.selected_location_range, " +
//            "p.selected_area_range, p.selected_floor_range, p.is_checked, p.product_name, " +
//            "p.product_title, p.latitude, p.longitude, ip.image " +
//            "FROM product p " +
//            "INNER JOIN imageproduct ip ON p.product_id = ip.product_id";

    String sql = "SELECT * FROM product";
    Query query = entityManager.createNativeQuery(sql);

    ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

    ArrayList<Product> products = new ArrayList<>();

    resultList.forEach(result -> {
        Product product = new Product();
        product.setProductId(((Number) result[0]).longValue());
        product.setSelectedPropertyType((String) result[1]);
        product.setSelectedPriceRange((String) result[2]);
        product.setSelectedRoomRange((String) result[3]);
        product.setSelectedBathRoomRange((String) result[4]);
        product.setSelectedLocationRange((String) result[5]);
        product.setSelectedAreaRange((String) result[6]);
        product.setSelectedFloorRange((String) result[7]);
        product.setIsChecked((boolean) result[8]);
        product.setProductName((String) result[9]);
        product.setProductTitle((String) result[10]);
        product.setLatitude((String) result[11]);
        product.setLongitude((String) result[12]);
//        product.setImages((List<ImageProduct>) result[13]);
        products.add(product);
    });

    return products;
    }


//    @Transactional(Transactional.TxType.SUPPORTS)
//    public List<byte[]> queryAllImage() {
//        String sql = "SELECT image FROM imageproduct";
//        Query query = entityManager.createNativeQuery(sql);
//
//        List<byte[]> images = query.getResultList();
//
//        return images;
//    }
@Transactional(Transactional.TxType.SUPPORTS)
public List<ImageProduct> queryAllImage() {
String sql = "SELECT image_id, image FROM imageproduct ";
//    String sql = " SELECT ip.image_id, p.product_id,ip.image " +
//            " FROM imageproduct ip " +
//            " INNER JOIN product p ON ip.product_id = p.product_id ";
    Query query = entityManager.createNativeQuery(sql);

    List<Object[]> resultList = query.getResultList();
    List<ImageProduct> images = new ArrayList<>();

    for (Object[] result : resultList) {
        ImageProduct imageProduct = new ImageProduct();
        imageProduct.setImageId(((Number) result[0]).longValue());
        imageProduct.setImage((byte[]) result[1]);

        images.add(imageProduct);
    }

    return images;
}



}

