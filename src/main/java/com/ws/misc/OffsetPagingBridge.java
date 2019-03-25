package com.ws.misc;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 */
public class OffsetPagingBridge extends PageRequest {

    private int offset;

    public OffsetPagingBridge(int page, int size, int offset, Sort sort) {
        super(page, size, sort);
        this.offset = offset;
    }

    @Override
    public int getOffset() {
        return offset;
    }
}
