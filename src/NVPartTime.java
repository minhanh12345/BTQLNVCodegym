public class NVPartTime extends NhanVienDaoTao{
    private int timeWork;
    public NVPartTime(){}

    public NVPartTime(String name, int age, String gender, String phone, String email, float luong, String nganh, int timeWork) {
        super(name, age, gender, phone, email, luong, nganh);
        this.timeWork = timeWork;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }
    public float getDoanhThu(){
        return timeWork*getLuong();
    }

    @Override
    public String toString() {
        return super.toString()+"NVPartTime{" +
                "timeWork=" + timeWork +"Doanh Thu "+getDoanhThu()+
                '}';
    }
}
