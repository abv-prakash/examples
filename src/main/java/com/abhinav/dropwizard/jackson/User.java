/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.dropwizard.jackson;

/**
 * 
 */
public class User {

  public enum Gender {
    MALE, FEMALE
  };

  public static class Name {
    private String _first, _last;

    public String getFirst() {
      return _first;
    }

    public String getLast() {
      return _last;
    }

    public void setFirst(String s) {
      _first = s;
    }

    public void setLast(String s) {
      _last = s;
    }
    
    @Override
    public String toString() {

      return "FirstName:" + this._first + ",LastName:" + this._last;
    }
  }

  private Gender _gender;
  private Name _name;
  private boolean _isVerified;
  private byte[] _userImage;

  public Name getName() {
    return _name;
  }

  public boolean isVerified() {
    return _isVerified;
  }

  public Gender getGender() {
    return _gender;
  }

  public byte[] getUserImage() {
    return _userImage;
  }

  public void setName(Name n) {
    _name = n;
  }

  public void setVerified(boolean b) {
    _isVerified = b;
  }

  public void setGender(Gender g) {
    _gender = g;
  }

  public void setUserImage(byte[] b) {
    _userImage = b;
  }

  @Override
  public String toString() {

    return "Name" + this._name + "Gender:" + this._gender + "Verified :" + this._isVerified
        + "Image:" + this._userImage;

  }


}
