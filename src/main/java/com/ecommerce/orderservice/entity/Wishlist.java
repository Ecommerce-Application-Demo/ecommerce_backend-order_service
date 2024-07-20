package com.ecommerce.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Wishlist {

    @Id
    private int wishlist_id;
    private String userId;
    @ElementCollection
    @CollectionTable(name = "style_id_list",joinColumns = @JoinColumn(name ="style_ids"))
    List<String> styleIdList = new ArrayList<>();
}
