package by.bsuir.exm.service.impl;

import by.bsuir.exm.dao.CompanyDao;
import by.bsuir.exm.dao.impl.CompanyDaoImpl;
import by.bsuir.exm.entity.Company;
import by.bsuir.exm.service.CompanyService;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateError;

import java.util.List;

@NoArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    CompanyDao companyDao = new CompanyDaoImpl();
    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            if(companyDao.updateCompany(company)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try {
            if(companyDao.deleteCompany(id)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> companies = null;
        try {
            companies = companyDao.showCompanies();
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return companies;
    }

    @Override
    public Company findCompanyById(int id) {
        Company company = null;
        try {
            company = companyDao.findCompanyById(id);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try {
            company = companyDao.findCompanyByName(name);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return company;
    }
}

