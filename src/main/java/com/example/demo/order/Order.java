package com.example.demo.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Document(collection = "order")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank
    @Field("customer_id")
    private String customerId;

    @Field("created_at")
    @CreatedDate
    private Instant createdAt;

    @Field("updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    @Version
    public Integer version;

   // @Field("status")
    //private OrderStatus status = OrderStatus.CREATED;

    @Field("payment_status")
    private Boolean paymentStatus = Boolean.FALSE;

   // @NotNull
    //@Field("payment_method")
    //private PaymentType paymentMethod;

    @NotNull
    @Field("payment_details")
    private String paymentDetails;

   // @Field("shipping_address")
    //private Address shippingAddress;

   // @Field("products")
   // @NotEmpty
    //private Set<@Valid Product> products;

    @Repository
    public interface OrderRepository extends MongoRepository<Order, String> {
    }
}
