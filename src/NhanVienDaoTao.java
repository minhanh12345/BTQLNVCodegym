public class NhanVienDaoTao extends NhanVien {
    private String nganh;

    public NhanVienDaoTao() {
    }

    public NhanVienDaoTao(String name, int age, String gender, String phone, String email, float luong, String nganh) {
        super(name, age, gender, phone, email, luong);
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override
    public String toString() {
        return super.toString()+"NhanVienDaoTao{" +
                "nganh='" + nganh + '\'' +
                '}';
    }
}
