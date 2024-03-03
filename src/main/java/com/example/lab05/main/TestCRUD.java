package com.example.lab05.main;

import com.example.lab05.DAO.ProductDAOImpl;
import com.example.lab05.model.ProductEntity;

import java.util.List;
import java.util.Scanner;

public class TestCRUD {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        do {
            System.out.println("1. Hiển thị toàn bộ dữ liệu");
            System.out.println("2. Hiển thị dữ liệu theo Mã Sản phẩm ");
            System.out.println("3. Thêm  mới");
            System.out.println("4. Sửa dữ liệu ");
            System.out.println("5. Xóa dữ liệu");
            System.out.println(" Bạn chọn:");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    List<ProductEntity> list = new ProductDAOImpl().getAllProduct();
                    if (list == null)
                        return;
                    for (ProductEntity item : list){
                        System.out.println("Mã Sản phẩm  "+item.getMaSp()
                                +"Tên Sản phẩm "+item.getTenSp()
                                +"Số Lượng "+item.getSoLuong()
                                +"Đơn giá"+item.getDonGia());
                    }
                break;
                case 2:
                    System.out.print("Nhập mã sản phẩm : ");
                    String maSP = sc.next();
                    ProductEntity product = new ProductDAOImpl().getProductById(maSP);
                    System.out.println("Mã Sản phẩm  "+product.getMaSp()
                            +"Tên Sản phẩm "+product.getTenSp()
                            +"Số Lượng "+product.getSoLuong()
                            +"Đơn giá"+product.getDonGia());
                    break;
                case 3:
                    ProductEntity Createproduct = new ProductEntity();
                    System.out.print("Nhập mã sản phẩm: ");
                    String Ma = sc.next();
                    System.out.print("Nhập tên sản phẩm: ");
                    String ten = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Nhập ảnh sản phẩm: ");
                    String anh = sc.nextLine();
                    System.out.print("Nhập số lượng sản phẩm: ");
                    Integer qty = sc.nextInt();
                    System.out.print("Nhập đơn giá sản phẩm: ");
                    Double gia = sc.nextDouble();
                    Createproduct.setMaSp(Ma);
                    Createproduct.setTenSp(ten);
                    Createproduct.setAnhSp(anh);
                    Createproduct.setSoLuong(qty);
                    Createproduct.setDonGia(gia);
                    Createproduct.setTrangThai(true);
                    boolean flag = new ProductDAOImpl().insertProduct(Createproduct);
                    if (flag == true ) System.out.println("Thêm mới dữ liệu thành công! ");
                    else System.out.println("Sảy ra lỗi thêm mới sản phẩm! ");
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần sửa: ");
                    String Maspofedit = sc.next();
                    ProductEntity p = new ProductDAOImpl().getProductById(Maspofedit);
                    System.out.print("Nhập tên sản phẩm: ");
                    String tensp = sc.next();
                    System.out.print("Nhập ảnh sản phẩm: ");
                    String anhsp = sc.next();
                    System.out.print("Nhập số lượng sản phẩm: ");
                    Integer qtysp = sc.nextInt();
                    System.out.print("Nhập đơn giá sản phẩm: ");
                    Double giasp = sc.nextDouble();
                    p.setMaSp(Maspofedit);
                    p.setTenSp(tensp);
                    p.setAnhSp(anhsp);
                    p.setSoLuong(qtysp);
                    p.setDonGia(giasp);
                    p.setTrangThai(true);
                    boolean flags = new ProductDAOImpl().updateProduct(p);
                    if (flags == true ) System.out.println("Sửa đổi dữ liệu thành công! ");
                    else System.out.println("Sảy ra lỗi sửa đổi sản phẩm! ");
                    break;
                case 5:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String Maspofdelete = sc.next();
                    boolean flagtodelete = new ProductDAOImpl().deleteProduct(Maspofdelete);
                    if (flagtodelete == true ) System.out.println("Đã xóa sản phẩm thành công! ");
                    else System.out.println("Sảy ra lỗi xóa sản phẩm! ");
                    break;
                default:
                    System.out.println("Không có lựa chọn nào như vậy, vui lòng chọn lại! ");
            }
        }while (true);
    }
}
