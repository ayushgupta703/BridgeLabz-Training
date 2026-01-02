abstract class JobRole {
    String roleName;

    JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

import java.util.ArrayList;
import java.util.List;

class Resume<T extends JobRole> {
    private T jobRole;

    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Processing resume for: " + role.getRoleName());
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager());

        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(seResume.getJobRole());
        resumeList.add(dsResume.getJobRole());
        resumeList.add(pmResume.getJobRole());

        processResumes(resumeList);
    }
}