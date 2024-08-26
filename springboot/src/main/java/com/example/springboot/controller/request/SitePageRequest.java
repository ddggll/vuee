package com.example.springboot.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 22457
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SitePageRequest extends BaseRequest{
    private String siteName;
    private String siteAddress;
    private String siteType;
    private String siteState;
}
