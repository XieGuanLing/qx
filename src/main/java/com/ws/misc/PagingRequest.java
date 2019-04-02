package com.ws.misc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by gl on 2019/4/1.
 */
@ApiModel(description = "分页请求")
public class PagingRequest {

    public static Pageable FIRST_RECORD = new PageRequest(0, 1);

    @ApiModelProperty("每页最大记录数,最大值为3000,默认为10")
    private Integer max;

    @ApiModelProperty("偏移记录数,默认为0")
    private Integer start;

    public PagingRequest() {
    }

    public Integer getMax() {
        return Math.min(
                this.max == null ? 10 : this.max,
                3000
        );
    }

    public PagingRequest(Integer max, Integer start) {
        this.max = max;
        this.start = start;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getUnLimitMax() {
        return Math.min(
                this.max == null ? 10 : this.max,
                10000
        );
    }

    public Integer getStart() {
        return this.start == null ? 0 : this.start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Pageable toPageable() {
        return toPageable(null);
    }

    public Pageable toPageable(Sort sort) {
        int max = this.max == null ? 10 : this.max;
        max = Math.min(max, 3000);
        if (max == 0)
            max = 1;

        int start = this.start == null ? 0 : this.start;
        if (start > 0)
            return new OffsetPagingBridge(start / max, max, start, sort);
        return new PageRequest(0, max, sort);
    }

    public Pageable toUnLimitPageable(Sort sort) {
        int max = getUnLimitMax() == null ? 10 : getUnLimitMax();
        max = Math.min(max, 10000);
        if (max == 0)
            max = 1;

        int start = getStart() == null ? 0 : getStart();
        if (start > 0)
            return new OffsetPagingBridge(start / max, max, start, sort);
        return new PageRequest(0, max, sort);
    }

    public Pageable toUnLimitPageable() {
        return toUnLimitPageable(null);
    }

    @Override
    public String toString() {
        return "PagingRequest{" +
                "max=" + max +
                ", start=" + start +
                '}';
    }
}
