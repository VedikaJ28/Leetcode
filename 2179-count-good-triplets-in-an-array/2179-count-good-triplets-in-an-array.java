import java.util.*;

public class Solution {
    public int goodTriplets(int[] nums1, int[] nums2) {
        List<List<Integer>> result = allCommonSubsequences(nums1, nums2);
        return extractTriplets(result).size();
    }

    private Map<String, Set<List<Integer>>> memo = new HashMap<>();

    private List<List<Integer>> allCommonSubsequences(int[] nums1, int[] nums2) {
        Set<List<Integer>> allSubsequences = dp(nums1, nums2, 0, 0);
        allSubsequences.removeIf(seq -> seq.size() <= 2);
        return new ArrayList<>(allSubsequences);
    }

    private Set<List<Integer>> dp(int[] nums1, int[] nums2, int i, int j) {
        String key = i + "|" + j;
        if (memo.containsKey(key)) return memo.get(key);

        Set<List<Integer>> result = new HashSet<>();

        if (i >= nums1.length || j >= nums2.length) {
            result.add(new ArrayList<>());
        } else {
            if (nums1[i] == nums2[j]) {
                for (List<Integer> subseq : dp(nums1, nums2, i + 1, j + 1)) {
                    List<Integer> newSeq = new ArrayList<>();
                    newSeq.add(nums1[i]);
                    newSeq.addAll(subseq);
                    result.add(newSeq);
                }
            }

            result.addAll(dp(nums1, nums2, i + 1, j));
            result.addAll(dp(nums1, nums2, i, j + 1));
        }

        memo.put(key, result);
        return result;
    }

    private Set<List<Integer>> extractTriplets(List<List<Integer>> subsequences) {
        Set<String> tripletsStr = new HashSet<>();

        for (List<Integer> subseq : subsequences) {
            int n = subseq.size();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        tripletsStr.add(subseq.get(i) + "," + subseq.get(j) + "," + subseq.get(k));
                    }
                }
            }
        }

        Set<List<Integer>> triplets = new HashSet<>();
        for (String s : tripletsStr) {
            List<Integer> triplet = new ArrayList<>();
            for (String val : s.split(",")) {
                triplet.add(Integer.parseInt(val));
            }
            triplets.add(triplet);
        }

        return triplets;
    }
}