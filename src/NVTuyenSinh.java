public class NVTuyenSinh extends NhanVien{
    private int numberNV;
    public NVTuyenSinh(){}

    public NVTuyenSinh(String name, int age, String gender, String phone, String email, float luong, int numberNV) {
        super(name, age, gender, phone, email, luong);
        this.numberNV = numberNV;
    }
    public float getDoanhThu(){
            return getLuong()*8+numberNV*10;
    }

    @Override
    public String toString() {
        return super.toString()+"NVTuyenSinh{" +
                "numberNV=" + numberNV +"Doanh thu "+getDoanhThu()+
                '}';
    }
}
