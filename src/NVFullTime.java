public class NVFullTime extends NhanVienDaoTao{
    public NVFullTime(){}

    public NVFullTime(String name, int age, String gender, String phone, String email, float luong,String nganh) {
        super(name, age, gender, phone, email, luong,nganh);
    }
    public float getDoanhThu(){
        return getLuong()*8;
    }

    @Override
    public String toString() {
        return super.toString()+"NVFullTime{}"+"Doanh Thu "+getDoanhThu();
    }

}
