package pe.edu.upc.employerservice.service;

import pe.edu.upc.employerservice.entity.Sector;

import java.util.List;

public interface SectorService {
    public List<Sector> listAllSector();
    public Sector getSector(Long id);
    public Sector createSector(Sector sector);
    public Sector updateSector(Sector sector);
    public void deleteSector(Sector sector);
}
