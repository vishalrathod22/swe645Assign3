package com.SWE.HW3.model;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="users")
//public class user {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	
////	@Column(name = "new")
////	private String newuser;
//	
//	@Column(name = "first_name")
//	private String firstName;
//	
//	@Column(name = "last_name")
//	private String lastName;
//	
////	@Column(name = "street address")
////	private String streetaddress;
////	
////	@Column(name = "email")
////	private String Email;
////	
////	@Column(name = "city")
////	private String City;
////	
////	@Column(name = "state")
////	private String state;
////	
////	@Column(name = "zipcode")
////	private String zipcode;
////	
////	@Column(name = "Telephone number")
////	private String Telephonenumber;
////	
////	@Column(name = "Dateofsurvey")
////	private String Dateofsurvey;
////	
////	@Column(name = "Things you liked most about the campus")
////	private String Thingsliked;
////	
////	@Column(name = "What made you interested in the university")
////	private String madeinterested;
////	
////	@Column(name = "Likelihood of him/her recommending this school to other students")
////	private String Likelihood;
////	
////	@Column(name = "Raffle")
////	private String Raffle;
////	
////	@Column(name = "Additional Comments")
////	private String Comments;
//}


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class user {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long studentId;
		private String firstName;
		private String lastName;
		private String streetAddress;
		private String city;
		private String state;
		private int zip;
		private String url;
		private String telphone;
		private String email;
		private String dos;
		private String[] likedMost;
		private String interested;
		private String recommendation;
		
		public user() {
			
		}

		public long getStudentId() {
			return studentId;
		}

		public void setStudentId(long studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getStreetAddress() {
			return streetAddress;
		}

		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getZip() {
			return zip;
		}

		public void setZip(int zip) {
			this.zip = zip;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getTelphone() {
			return telphone;
		}

		public void setTelphone(String telphone) {
			this.telphone = telphone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDos() {
			return dos;
		}

		public void setDos(String dos) {
			this.dos = dos;
		}

		public String[] getLikedMost() {
			return likedMost;
		}

		public void setLikedMost(String[] likedMost) {
			this.likedMost = likedMost;
		}
		public String getInterested() {
			return interested;
		}

		public void setInterested(String interested) {
			this.interested = interested;
		}

		public String getRecommendation() {
			return recommendation;
		}

		public void setRecommendation(String recommendation) {
			this.recommendation = recommendation;
		}

		public user(long studentId, String firstName, String lastName, String streetAddress, String city,
				String state, int zip, String url, String telphone, String email, String dos, String[] likedMost,
				 String interested, String recommendation) {
			super();
			this.studentId = studentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.url = url;
			this.telphone = telphone;
			this.email = email;
			this.dos = dos;
			this.likedMost = likedMost;
			this.interested = interested;
			this.recommendation = recommendation;
		}
}
