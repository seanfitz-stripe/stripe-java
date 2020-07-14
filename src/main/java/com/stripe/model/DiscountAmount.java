package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DiscountAmount extends StripeObject {
  /** The amount, in %s, of the discount. */
  @SerializedName("amount")
  Long amount;

  /** The discount that was applied to get this discount amount. */
  @SerializedName("discount")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Discount> discount;

  /** Get ID of expandable {@code discount} object. */
  public String getDiscount() {
    return (this.discount != null) ? this.discount.getId() : null;
  }

  public void setDiscount(String id) {
    this.discount = ApiResource.setExpandableFieldId(id, this.discount);
  }

  /** Get expanded {@code discount}. */
  public Discount getDiscountObject() {
    return (this.discount != null) ? this.discount.getExpanded() : null;
  }

  public void setDiscountObject(Discount expandableObject) {
    this.discount = new ExpandableField<Discount>(expandableObject.getId(), expandableObject);
  }
}
