/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aqsaindia.boqtobom.entities.ContactTable;

public interface IContactRepository extends JpaRepository<ContactTable, Integer> {

}
